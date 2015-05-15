Messenger.options = {
	extraClasses : 'messenger-fixed messenger-on-bottom messenger-on-right',
	theme : 'future'
};


$.ajax({
	url : "rest/user/getLoggedInUser",
	type : "GET",
	contentType : "application/json",
	async: true,
	success : function(adminUser, textStatus, jqXHR) {
		if (adminUser) {
			$('.username').html(adminUser.fullname);
		}
	}
});