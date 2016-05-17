// JavaScript event handlers for dict.html 
$(function () {
	Dictionary.init();
});

var Dictionary = {
	word : $('#input-word').val(),
	init: function() {
            $('#submit-word').on('click',function () {
                    Dictionary.sendAjaxRequest();
            });
	},
	sendAjaxRequest: function () {
		$.ajax({
                    url:'dictServlet',
                    type:'post',
                    dataType:'json',
                    success:function (response) {
                    	console.log(response);
                    }
		});
	}
};