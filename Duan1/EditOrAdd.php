
<?php
require_once 'database.php';

if (!empty($_POST)) {
	$s_id = '';

	if (isset($_POST['tieude'])) {
		$s_tieude = $_POST['tieude'];
	}

	if (isset($_POST['linkimg'])) {
		$s_linkimg = $_POST['linkimg'];
	}

	if (isset($_POST['price'])) {
		$s_price = $_POST['price'];
	}
	if (isset($_POST['tragop'])) {
		$s_tragop = $_POST['tragop'];

		//echo $s_tragop;
	}
	if (isset($_POST['detail'])) {
		$s_detail = $_POST['detail'];
	}

	if (isset($_POST['id'])) {
		$s_id = $_POST['id'];
	}

	$s_tieude = str_replace('\'', '\\\'', $s_tieude);
	$s_linkimg = str_replace('\'', '\\\'', $s_linkimg);
	$s_price = str_replace('\'', '\\\'', $s_price);
	$s_tragop = str_replace('\'', '\\\'', $s_tragop);
	$s_detail = str_replace('\'', '\\\'', $s_detail);
	$s_id = str_replace('\'', '\\\'', $s_id);

	if ($s_id != '') {
		//update
		$sql = "update product set tieude = '$s_tieude', linkimg = '$s_linkimg', price = '$s_price',tragop='$s_tragop',detail='$s_detail' where id = " . $s_id;
	} else {
		//insert
		$sql = "insert into product(tieude, linkimg, price,tragop,detail) value ('$s_tieude', '$s_linkimg', '$s_price','$s_tragop','$s_detail')";
	}
	// echo '<script language="javascript">';

	// echo 'alert("' . $sql . '")';
	// echo '</script>';
	// echo $sql;
	echo $sql;
	execute($sql);

	header('Location: admin.php');
	die();
}

$id = '';
//echo "co chay vao day";
$tieude = $linkimg = $price = $tragop = $detail = '';
if (isset($_GET['id'])) {
	$id = $_GET['id'];
	$sql = 'select * from product where id = ' . $id;
	//echo $sql;
	$productList = execute_result($sql);
	if ($productList != null && count($productList) > 0) {
		$std = $productList[0];
		$tieude = $std['tieude'];
		$linkimg = $std['linkimg'];
		$price = $std['price'];
		$tragop = $std['tragop'];
		$detail = $std['detail'];
	} else {
		$id = '';
	}
}
?>
<!DOCTYPE html>


<html>
<head>
	<title></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<form action="" method="POST">



			<div class="form-group">
				<label for="tieude">Tiêu Đề</label>
				<input type="number" name="id" value="<?=$id?>" style="display: none;">
				<input type="text" class="form-control" name="tieude" id="tieude" value="<?=$tieude?>">
			</div>

			<div class="form-group">
				<label for="linkimg">Link Img</label>
				<input type="text" class="form-control" name="linkimg" id="linkimg" value="<?=$linkimg?>">
			</div>
			<div class="form-group">
				<label for="price">Price</label>
				<input type="text" class="form-control" name="price" id="price" value="<?=$price?>">
			</div>
			<div class="form-group">
				<label for="pwd">Trả Góp:</label>
				<input type="text" class="form-control" name="tragop" id="tragop" value="<?=$tragop?>">
			</div>

			<div class="form-group">
				<label for="pwd">Thong Tin Chi Tiet:</label>
				<input type="text" class="form-control" name="detail" id="detail" value="<?=$detail?>">
			</div>


			<button class="btn btn-success" >Save</button>
		</form>

	</div>



</body>
</html>