<?php 
include('dbmysql.php');

if(isset($_COOKIE['status']) && ($_COOKIE['status']=='success')){
	header('Location: wellcome.php');
}
if(!empty($_POST)){
	
	$email = $_POST['email'];

	$password = $_POST['password'];
	
	

	$query= "SELECT * FROM user2 WHERE EMAIL='".$email."' AND PASSWORD='".$password."'";
	//echo $query.'<br/>';
	
	$user_list =execute_result($query);
	if(count($user_list)>0){
		setcookie('status', 'success', time()+3600, '/');
		header('Location: wellcome.php');

		
	}else{
		echo '<script language="javascript">';
		echo 'alert("login faild")';
		echo '</script>';

	}
	
	
}

?>

