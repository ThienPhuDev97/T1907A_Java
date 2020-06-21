<?php 
require_once('dbmysql.php');

?>
<!DOCTYPE html>
<html>
<head>
	<title>Student Management</title>
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
			<div class="panel-heading">
				Quản lý thông tin sinh viên
				<form method="get">
					<input type="text" name="timkiem" class="form-control" style="margin-top: 15px; margin-bottom: 15px;" placeholder="Tìm kiếm theo tên">
				</form>
			</div>
			<div class="panel-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>BookName</th>
							<th>AuthorName</th>
							<th>Price</th>
							<th>PublishingCompany</th>
							<th width="60px"></th>
							<th width="60px"></th>
						</tr>
					</thead>
					<tbody>
						<?php 
						if(isset($_GET['timkiem'])&&  $_GET['timkiem'] != ''){
							$sql = 'select * from book where BookName like "%'.$_GET['timkiem'].'%"';
						}else{
							$sql = 'select * from book';
						}
						
						$listBook = execute_result($sql);
						$index = 1;
						foreach ($listBook as  $value) {
							echo '<tr>
							<td>'.($index++).'</td>
							<td>'.$value['BookName'].'</td>
							<td>'.$value['AuthorName'].'</td>
							<td>'.$value['Price'].'</td>
							<td>'.$value['PublishingCompany'].'</td>
							<td><button class="btn btn-warning" onclick=\'window.open("editbook.php?id='.$value['ID'].'","_self")\'>Edit</button></td>
							<td><button class="btn btn-danger" onclick="deletedID('.$value['ID'].')">Delete</button></td>
							</tr>';
						}
						?>
					</tbody>
				</table>
				<button class="btn btn-success" onclick="window.open('editbook.php', '_self')">Add Student</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function deletedID(id){
			option = confirm('Ban co muon xoa book nay ko')
			if(!option) {
				return;
			}
			console.log(id)
			$.post('deletedBook.php', {
				'id': id
			}, function(data) {
				alert(data)
				location.reload()
			})
		}
	</script>
	
</body>
</html>