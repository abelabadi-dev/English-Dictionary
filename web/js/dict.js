// JavaScript event handlers for dict.html 
$(function () {
	Dictionary.init();
});

var Dictionary = {
	'word':"",
	init: function() {
            $('#submit-word').on('click',function (event) {
                Dictionary.word= $('#input-word').val();
                Dictionary.sendAjaxRequest();
            });
	},
	sendAjaxRequest: function () {
            console.log("Ajax:"+Dictionary.word);
		$.ajax({
                    url:'dictServlet',
                    type:'POST',
                    dataType:'json',
                    data: {'word':Dictionary.word},
                    success:Dictionary.displayResponse
		}).fail(function (parameters) {
            console.log("failed");
            });
	},
        displayResponse: function (response) {
            
            console.log(response);
        }
};