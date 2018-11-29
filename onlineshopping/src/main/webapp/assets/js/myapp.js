$(function() {
	
	switch(menu) {
		
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Order':
		$('#order').addClass('active');
	default:
		$('#home').addClass('active');
		break;
	}
	
});
