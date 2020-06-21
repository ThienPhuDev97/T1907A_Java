
<?php
require_once ('dbmysql.php');



if (!empty($_POST)) {
	$s_id = '';

	if (isset($_POST['bookname'])) {
		$s_BookName = $_POST['bookname'];
	}

	if (isset($_POST['authorname'])) {
		$s_authorname = $_POST['authorname'];
	}

	if (isset($_POST['price'])) {
		$s_price = $_POST['price'];
	}
	if (isset($_POST['PublishingCompany'])) {
		$s_PublishingCompany = $_POST['PublishingCompany'];
	}

	if (isset($_POST['id'])) {
		$s_id = $_POST['id'];
	}

	$s_BookName = str_replace('\'', '\\\'', $s_BookName);
	$s_authorname      = str_replace('\'', '\\\'', $s_authorname);
	$s_price  = str_replace('\'', '\\\'', $s_price);
	$s_PublishingCompany  = str_replace('\'', '\\\'', $s_PublishingCompany);
	$s_id       = str_replace('\'', '\\\'', $s_id);

	

	if ($s_id != '') {
		//update
		$sql = "update book set BookName = '$s_BookName', AuthorName = '$s_authorname', Price = '$s_price',PublishingCompany='$s_PublishingCompany' where ID = " .$s_id;
	} else {
		//insert
		$sql = "insert into book(BookName, AuthorName, Price,PublishingCompany) value ('$s_BookName', '$s_authorname', '$s_price','$s_PublishingCompany')";
	}
	echo '<script language="javascript">';

	echo 'alert("'.$sql.'")';
	echo '</script>';
	// echo $sql;

	execute($sql);

	header('Location: wellcome.php');
	die();
}

$id = '';
//echo "co chay vao day";
$BookName= $AuthorName= $Price=$PublishingCompany='';
if (isset($_GET['id'])) {
	$id          = $_GET['id'];
	$sql         = 'select * from book where ID = '.$id;
	//echo $sql;
	$bookList = execute_result($sql);
	if ($bookList != null && count($bookList) > 0) {
		$std        = $bookList[0];
		$BookName = $std['BookName'];
		$AuthorName      = $std['AuthorName'];
		$Price  = $std['Price'];
		$PublishingCompany  = $std['PublishingCompany'];
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
				<label for="BookName">BookName</label>
				<input type="number" name="id" value="<?=$id?>" style="display: none;">
				<input type="text" class="form-control" name="bookname" id="bookname" value="<?=$BookName?>">
			</div>

			<div class="form-group">
				<label for="authorname">Author Name</label>
				<input type="text" class="form-control" name="authorname" id="authorname" value="<?=$AuthorName?>">
			</div>
			<div class="form-group">
				<label for="price">Price</label>
				<input type="text" class="form-control" name="price" id="price" value="<?=$Price?>">
			</div>
			<div class="form-group">
				<label for="pwd">PublishingCompany:</label>
				<input type="text" class="form-control" name="PublishingCompany" id="PublishingCompany" value="<?=$PublishingCompany?>">
			</div>

			


			<button class="btn btn-success">Save</button>
		</form>

	</div>



</body>
</html>