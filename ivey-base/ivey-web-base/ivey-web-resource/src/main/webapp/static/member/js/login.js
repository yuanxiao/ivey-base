jQuery(document).ready(function() {

	if (!isNull(loginError)) {
		jQuery("#error-message").text(loginError);
		jQuery("#error-message").parent().show();
	}

	jQuery("#loginBtn").on("click", function() {
		if (validateForm()) {
			Login.login();
		}
	});
});

var Login = {
	login : function() {
		jQuery("#fm1").attr("action", "http://localhost:8082/member/login");
		jQuery("#fm1").attr("method", "post");
		jQuery("#fm1").submit();
	},
};
function validateForm() {

	var result = true;
	jQuery("#fm1").find(" input ").each(function() {
		if (isNull(this.value)) {
			result = false;
			jQuery("#error-message").text(jQuery(this).attr('required-msg'));
			jQuery("#error-message").parent().show();
			return false;
		}
	});
	return result;
}
