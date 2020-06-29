<?php
	include('database.php');
	// $tieude = 'Samsung Galaxy Note 10 Lite';
	// $tragop = 'TRẢ GÓP 1%';
	// $price = '10.000.000VND';
	// $linkimg = 'img/content1.jfif';


// INSERT INTO `product` (`id`, `tieude`, `linkimg`, `price`, `tragop`) VALUES (NULL, '\'Iphone 12\'', '\'TRẢ GÓP 1%\'', '20.000.000VND', '\'img/content1.jfif\''); 
	$sql = "select * from product";
	//echo $sql;
	$productList = execute_result($sql);
	//echo count($productList);
	// foreach ($productList as  $value) {
	// 	echo $value['tieude'].$value['price'].'<br/>';
	// }

?>