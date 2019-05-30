/**
 * method: 请求方式get或post
 * url：请求地址
 * data：请求数据无传null，有格式为“a=1&b=2”
 * del200,del404,del500:接受一个js函数
 * */
function myAjax(method,url,data,del200,del404,del500,async){
    //创建ajax
    var ajax = getAjax()
    //复写onreadystatechange
    ajax.onreadystatechange=function () {
        //判断ajax状态
        if(ajax.readyState==4){
            if(ajax.status==200){
                if(del200){
                    del200(ajax);
                }
            }else if(ajax.status==404){
                if (del404){
                    del404(ajax);
                }
            }else if(ajax.status==500){
                if (del500){
                    del500(ajax);
                }
            }
        }
    }
    //发送请求
    if("get"==method){
        ajax.open("get",url+(data==null?"":"?"+data),async);
        ajax.send(null);
    }else if("post"==method){
        ajax.open("post",url,async);
        ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        ajax.send(data);
    }
}
/*--------------------------------*/
function getAjax() {
    var ajax;
    if(window.XMLHttpRequest){
        ajax=new XMLHttpRequest();
    }else if(window.ActiveXObject) {
        ajax = new ActiveXObject("Msxml2.XMLHTTP");
    }
    return ajax;
}