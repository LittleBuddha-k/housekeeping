/**
 *工具组件 对原有的工具进行封装，自定义某方法统一处理
 */
(function () {
    hk={
        /**
         * 跳转到另一个页面
         * @param url
         */
        go:function (url) {
            window.location.href = url;
        },
        /**
         * 打开小窗口
         * @param url
         * @param title
         */
        open:function (url,title,size) {
            window.open(url,title,size);
        },
        info:function(message){
            alert(message);
        },
        confirm:function(message){
          confirm(message);
        },
        getSelectId:function () {
            var checkedBox = $("input[name='checkChild']:checked");
            if (checkedBox.length == 0) {
                alert("请先选择绑定的记录！");
                return;
            } else {
                var chk_value = [];
                $('input[name="checkChild"]:checked').each(function () {
                    //var method =  $("#" + $(this).val()).val();
                    chk_value.push($(this).val());
                });
                return chk_value;
            }
        },
        get:function (url,callback) {
            $.ajax({
                url:url,
                method:"get",
                error:function(xhr,textStatus){
                    hk.alert("操作失败");
                },
                success:function(data){
                      callback(data);
                }
            });
        }
    }
})(jQuery);