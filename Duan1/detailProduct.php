<!DOCTYPE html>
<?php

require_once 'xuli.php';
if (isset($_GET['id'])) {
	$id = $_GET['id'];
	$sql_id = 'select * from product where id =' . $id;
	$product_id = execute_result($sql_id);
	$tieude = $product_id[0]['tieude'];
	$link = $product_id[0]['linkimg'];
	$price = $product_id[0]['price'];
	$tragop = $product_id[0]['tragop'];
	$detail = $product_id[0]['detail'];
	//echo ;
}
?>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style type="text/css">
	.p1{
		 font-weight:bold;
	}
</style>
</head>
<body>

	<div class="container">

		<div id="header" style="width: 100%">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/img1.png.jfif" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/img1.png.jfif" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/img3.jfif" class="d-block w-100" alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" >
				<img src='img/vinsmart1.png.jfif' class="card-img-top editing" alt="...">
			</div>
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style=" margin-top:30px">
				<p class="p1"><?=$tieude?></p>
				<p class="p1"><?=$price?></p>
				<p class="p1" style="color:red"><?=$tragop?></p>
				<p>Thông số kỹ thuật</p>
				<p><?=$detail?></p>

			</div>
		</div>


	</div>
</div>
</body>
</html>