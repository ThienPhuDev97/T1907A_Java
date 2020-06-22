<!DOCTYPE html>

<html>
<head>
	<title>Thanh Toan</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				Thanh Toan San Pham
				
			</div>
			<div class="panel-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>San Pham</th>
							<th>So Luong</th>
							<th>Price</th>
							
							
						</tr>
					</thead>
					<tbody>
						<?php 
						$index = 1;
						$getArrayCookie = array();
						$length = count($_COOKIE)/3;
						for ($i=0; $i < $length; $i++) {

							$tieude = 'tieude'.$i.'';
							$price ='price'.$i.'';
							$soluong='soluong'.$i.'';
							//echo $check;
							//echo ($_COOKIE[''.$tieude.'']);
							$s_tieude=$_COOKIE[''.$tieude.''];
							$s_price =$_COOKIE[''.$price.''];
							$s_soluong = $_COOKIE[''.$soluong.''];
							// echo $s_tieude;
							// echo $s_price;
							// //echo ($_COOKIE[''.$soluong.'']);
							// echo $s_soluong;
							// echo "<br/>";	


							echo '<tr>
							<td>'.($index++).'</td>
							<td>'.$s_tieude.'</td>
							<td>'.$s_soluong.'</td>
							<td>'.$s_price.'</td>

							</tr>';



							// $array=($_COOKIE['tieude'.$i],'1', $_COOKIE['price'.$i] );
							// $getArrayCookie[$i]=$array;
						}
							//echo $getArrayCookie[0]['tieude'];
						//echo $_COOKIE['tieude'.0''];
						
						

						?>
					</tbody>
				</table>
				<button class="btn btn-success" >Payment</button>
			</div>
		</div>
	</div>
</body>
</html>