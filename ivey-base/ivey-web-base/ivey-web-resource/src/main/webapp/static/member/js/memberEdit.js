$(document).ready(function() {
	$.validator.setDefaults({
		submitHandler : function() {
			alert("submitted!");
		},
		showErrors : function(map, list) {
			var focussed = document.activeElement;
			if (focussed && $(focussed).is("input, textarea")) {
				$(this.currentForm).tooltip("close", {
					currentTarget : focussed
				}, true)
			}
			this.currentElements.removeAttr("title").removeClass("ui-state-highlight");
			$.each(list, function(index, error) {
				$(error.element).attr("title", error.message).addClass("ui-state-highlight");
			});
			if (focussed && $(focussed).is("input, textarea")) {
				$(this.currentForm).tooltip("open", {
					target : focussed
				});
			}
		}
	});
	(function() {
		// use custom tooltip; disable animations for now to work around lack of
		// refresh method on tooltip
		$("#commentForm, #signupForm").tooltip({
			show : false,
			hide : false
		});
		// validate the comment form when it is submitted
		$("#commentForm").validate();
		// validate signup form on keyup and submit
		$("#signupForm").validate({
			rules : {
				firstName : {
					required : true,
					minlength : 2,
				},
				lastName : {
					required : true,
					minlength : 2,
				},
				email : {
					required : true,
					email : true
				},
				birthday : {
					required : true,
				},
				mobilePhone : {
					required : true,
				},
			},
			messages : {
				firstName : {
					required : "Please enter your firstname",
					minlength : "Your  first name  must consist of at least 2 characters"
				},
				lastName : {
					required : "Please enter a last name",
					minlength : "Your  last name  must consist of at least 2 characters"
				},
				email : "Please enter a valid email address",
				birthday : "Please enter your birthday",
				mobilePhone : "Please enter your mobile",
			}
		});
		// propose username by combining first- and lastname
		$("#username").focus(function() {
			var firstname = $("#firstname").val();
			var lastname = $("#lastname").val();
			if (firstname && lastname && !this.value) {
				this.value = firstname + "." + lastname;
			}
		});
		// code to hide topic selection, disable for demo
		var newsletter = $("#newsletter");
		// newsletter topics are optional, hide at first
		var inital = newsletter.is(":checked");
		var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
		var topicInputs = topics.find("input").attr("disabled", !inital);
		// show when newsletter is checked
		newsletter.click(function() {
			topics[this.checked ? "removeClass" : "addClass"]("gray");
			topicInputs.attr("disabled", !this.checked);
		});
		$("#signupForm input:not(:submit)").addClass("ui-widget-content");
		$(":submit").button();
	})();

});