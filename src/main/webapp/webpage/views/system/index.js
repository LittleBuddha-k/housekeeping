<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    function getMenu(id) {
        var html ="";
        $.ajax({
            type:"post",// get或者post
            url:"/housekeeping/system/menu/data?parentId="+id,// 请求的url地址
            data:"",//请求的参数
            dataType:"json",//json写了jq会帮我们转换成数组或者对象 他已经用JSON.parse弄好了
            //timeout:3000,//3秒后提示错误
            beforeSend:function(){
                // 发送之前就会进入这个函数
                // return false 这个ajax就停止了不会发 如果没有return false 就会继续
            },
            success:function(list){ // 成功拿到结果放到这个函数 data就是拿到的结果
                for(var i=0;i<list.length;i++){
                    var secondLevelMenu= $("#secondLevelMenu").html();
                    html += laytpl(secondLevelMenu).render(list[i]);
                }
                $("#test-menu").append(html);
                console.log(html)
            },
            error:function(){//失败的函数
            },
            complete:function(){//不管成功还是失败 都会进这个函数
            }
        })
    }
</script>
