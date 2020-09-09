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
        open:function (url,title) {
            window.open(url,title,'height=60%, width=70%, top=10%,left=20%, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
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
    }
})(jQuery);