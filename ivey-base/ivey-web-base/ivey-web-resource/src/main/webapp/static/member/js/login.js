jQuery(document).ready(function() {

	jQuery("#loginBtn").on("click", function() {
			Login.login();
	});

});

var Login = {

	login : function() {
		jQuery.ajax({
			url : "/member/login",
			data : {
				userName : jQuery("input[name='userName']").val(),
				userPwd : jQuery("input[name='userPwd']").val()
			},
			type : "post",
			successL : function(data) {
				console.dir(data);
			},
			error : function() {

			}

		});
	},
};