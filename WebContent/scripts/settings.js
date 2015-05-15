function updateUser() {
	if ($('#password').val() == '' || $('#confirmpassword').val() == '') {
		$('#confirmpassword').parent().removeClass('has-success').addClass(
				'has-error');
		$('#password').parent().removeClass('has-success')
				.addClass('has-error');

	} else if ($('#password').val() != $('#confirmpassword').val()) {
		$('#confirmpassword').parent().removeClass('has-success').addClass(
				'has-error');
		$('#password').parent().removeClass('has-success')
				.addClass('has-error');

	} else if ($('#question').val() != '' && $('#answer').val() == '') {
		$('#answer').parent().removeClass('has-success').addClass('has-error');
	} else {

		$('#confirmpassword').parent().removeClass('has-error').addClass(
				'has-success');
		$('#password').parent().removeClass('has-error')
				.addClass('has-success');
		$('#answer').parent().removeClass('has-error').addClass('has-success');

		var postData = new Object();
		postData.fullname = $('#fullname').val();
		postData.username = $('#username').val();
		postData.password = $('#password').val();
		postData.securityQuestion = $('#question').val();
		postData.securityAnswer = $('#answer').val();

		$.ajax({
			url : "rest/user/update",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(postData),
			success : function(userDetails, textStatus, jqXHR) {
				if (userDetails) {
					Messenger().post({
						message : "User details saved sucessfully!",
						showCloseButton : true
					});
				}
			},
			error : function(xhr, textStatus, errorThrown) {
				Messenger().post({
					message : "Error while saving user details.",
					showCloseButton : true
				});
			}
		});
	}
}

function getUser() {

	$.ajax({
		url : "rest/user/get/admin",
		type : "GET",
		contentType : "application/json",
		async : false,
		success : function(user, textStatus, jqXHR) {
			if (user) {
				$('#fullname').val(user.fullname);
				$('#username').val(user.username);
				$('#username').attr("disabled", "");
				$('#password').val(user.password);
				$('#confirmpassword').val(user.password);
				$('#question').val(user.securityQuestion);
				$('#answer').val(user.securityAnswer);
			}
		},
		error : function(xhr, textStatus, errorThrown) {
			Messenger().post({
				message : "Error happened while fetching user details!",
				showCloseButton : true
			});
		}
	});

}