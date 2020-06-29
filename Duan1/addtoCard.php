<?php

include('database.php');

if(!empty($_POST)){

	$mang = array();
	$myArray = array();
	$myArray = json_decode($_POST['myarray']);
	//echo count($myArray);

	for ($i=0; $i <count($myArray) ; $i++) { 
		$sql = 'select * from product where id ='.$myArray[$i];
		$mang[$i] = execute_result($sql);
	}
	for ($i=0; $i < count($mang); $i++) {
		echo $mang[$i][0]['tieude'].$mang[$i][0]['price'].'<br/>';
	}

	 for ($i=0; $i < count($mang); $i++) {
	 		setcookie('tieude'.$i,$mang[$i][0]['tieude'],time()+3600,'/');
	 		setcookie('price'.$i,$mang[$i][0]['price'],time()+3600,'/');
	 		setcookie('soluong'.$i,1,time()+3600,'/');
	 }
	
}
?>
