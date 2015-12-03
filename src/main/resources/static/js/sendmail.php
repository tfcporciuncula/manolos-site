<?php
if (!isset($_POST['submit'])) {
	/* Set e-mail recipient */
	$to = 'manolos.corp@gmail.com';

	/* Check all form inputs using check_input function */	
	$subject = 'Email from website';
	$name = $_POST['name'];
	$email = $_POST['email'];

	$message = $_POST['message']."\n\n".$name;
	$headers = 'From: '.$email . "\r\n" .
    	'Reply-To: '.$email . "\r\n" .
	    'X-Mailer: PHP/' . phpversion();
	
		/* Send the message using mail() function */
	mail($to, $subject, $message, $headers);
 
 	echo '<script language="javascript">document.getElementById("contactForm").style.display="none";</script>';
	echo '<script language="javascript">document.getElementById("confirm").style.visibility="visible";</script>';
// 	$thanks = 'Muito obrigado '.$name', sua mensagem foi enviada com sucesso!';
// 	$thanksScript = '<script language="javascript">document.getElementById("confirm2").setAttribute("value", '.$thanks.');</script>';
// 	echo $thanksScript;

// 	echo '<script language="javascript">';
// 	echo 'alert("message successfully sent")';
// 	echo '</script>';
} else {
	echo '<script language="javascript">';
	echo 'alert("message not sent")';
	echo '</script>';
}
	
// 	/* Redirect visitor to the thank you page */
// 	header('Location: thankyou.htm');
// 	exit();
?>