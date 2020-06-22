<?php
define('HOST', 'localhost');
define('DATABASE', 'quanlysanpham');
define('USERNAME', 'root');
define('PASSWORD', '');

function execute($sql){
	//insert, update, delete du lieu vao database
	// start : insert into database
	// tao ket noi toi CSDL
	
	$connect = mysqli_connect(HOST, USERNAME, PASSWORD, DATABASE);

	mysqli_query($connect,$sql);

	if($connect ->connect_error){
		var_dump($connect ->connect_error);
		die();
	}
	mysqli_close($connect);
}

function execute_result($sql){
	// start : select from database
	// tao ket noi toi CSDL
	 $resultList= array();
	$connect =mysqli_connect(HOST, USERNAME, PASSWORD, DATABASE);

	$resultset = mysqli_query($connect,$sql);
	while ($row = mysqli_fetch_array($resultset, 1)) {
		$resultList[] = $row;
	}
	//var_dump($resultList);
	mysqli_close($connect);

	return $resultList;
}