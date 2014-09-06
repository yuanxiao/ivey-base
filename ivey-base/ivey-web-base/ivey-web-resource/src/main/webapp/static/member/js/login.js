jQuery(document).ready(function() {

	jQuery("#loginBtn").on("click", function() {
		if (validateForm()) {
			jQuery("#fm1").submit();
			Login.login();
		}
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
function validateForm() {

	jQuery("#fm1").find(" input ").each(function(){
			if(isNull(this.value)){
				jQuery("#error-message").text(jQuery(this).attr('required-msg'));
				jQuery("#error-message").parent().show();
				return false;
			}
	});
}
