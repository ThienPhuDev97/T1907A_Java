<?php
include('dbmysql.php');


if (!empty($_POST['UserName'])){

	if(isset($_POST['UserName'])){
		$UserName = $_POST['UserName'];
	}
	if(isset($_POST['fullname'])){
		$fullname = $_POST['fullname'];
	}
	if(isset($_POST['email'])){
		$email = $_POST['email'];
	}
	if(isset($_POST['Password'])){
		$Password = $_POST['Password'];
	}
	if(isset($_POST['phone'])){
		$phone = $_POST['phone'];
	}
	
	//echo $BookName;

// 	// setcookie('fullname',$fullname,time()+3600,'/');
// 	// setcookie('email',$email,time()+3600,'/');
// 	// setcookie('password',$password,time()+3600,'/');
// 	// setcookie('address',$address,time()+3600,'/');

	
	$sql = "insert into user2(username,fullname,email,PASSWORD,phone) values ('$UserName','$fullname', '$email',
	 '$Password','phone')";
	execute($sql);
	

	echo "Dang ki thanh cong";

}


?>