<?php
require_once 'xuli.php';
?>
<!DOCTYPE html>
<html>
<head>
	<title>Admin</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<h1 style="margin-top:50px; margin-bottom: 30px "><center>Admin</center></h1>
			<div class="panel-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>TieuDe</th>
							<th>Url Image</th>
							<th>Price</th>
							<th>Tra Gop</th>
							<th>Thong tin chi tiet</th>
							<th width="60px"></th>
							<th width="60px"></th>
						</tr>
					</thead>
					<tbody>
						<?php

$index = 1;
foreach ($productList as $value) {
	echo '<tr>
							<td>' . ($index++) . '</td>
							<td>' . $value['tieude'] . '</td>
							<td>' . $value['linkimg'] . '</td>
							<td>' . $value['price'] . '</td>
							<td>' . $value['tragop'] . '</td>
							<td>' . $value['detail'] . '</td>
							<td><button class="btn btn-warning" onclick=\'window.open("EditOrAdd.php?id=' . $value['id'] . '","_self")\'>Edit</button></td>
							<td><button class="btn btn-danger" onclick="deletedID(' . $value['id'] . ')">Delete</button></td>
							</tr>';
}
?>
					</tbody>
				</table>
				<button class="btn btn-success" onclick="window.open('EditOrAdd.php', '_self')">Add Product</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function deletedID(id){
			option = confirm('Ban co muon xoa san pham nay ko')

			if(!option) {
				return;
			}
			console.log(id)
			$.post('deletedProduct.php', {
				'id': id
			}, function(data) {
				alert(data)
				location.reload()
			})
		}
	</script>

</body>
</html>