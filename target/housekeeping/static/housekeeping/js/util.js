(function() {
    hk = {
        open:function (url,title,width,height) {
            window.open(url, title, 'height='+ height + ',width=' + width + ' top=100, left=150');
            $("#title").val(title);
        },
        ajaxGet:function (url,callBack) {
            $.ajax({
                url: url,    //请求的url地址
                method:"get",
                dataType: "json",   //返回格式为json
                error:function(){

                },
                success: function (data) {
                    //请求成功时处理
                    if (data.status != 200) {
                        alert(data.message);
                    } else {
                        callBack(data);
                    }
                }
            })
        },
        ajaxPost:function(url,data,callback){
            $.ajax({
                url:url,
                method:"post",
                data:data,
                error:function(data){
                    alert(data.message);
                },
                success:function(data){
                    if(data.status == 200){//登录超时
                        callback(data);
                    }
                }
            });
        },
        getId:function () {
        var ids = [];
        $.each($('input:checkbox:checked'), function () {
            ids.push($(this).val());
        });
        return ids;
    }
    }
})(jQuery);