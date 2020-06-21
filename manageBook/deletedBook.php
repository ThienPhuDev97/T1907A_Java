<?php
if (isset($_POST['id'])) {
	$id = $_POST['id'];

	require_once ('dbmysql.php');
	$sql = 'delete from book where ID = '.$id;
	execute($sql);

	echo 'Xoá book book thanh cong';
}