<?php 
	include "connection.php";

	$saxeli = $_POST['saxeli']; //call of duty
	$janri = $_POST['janri'];
	$weli = $_POST['weli'];
	$shemqmneli = $_POST['shemqmneli'];
	$mogeba = $_POST['mogeba'];
	$cover = $_POST['cover'];
	var_dump($saxeli);


	$test = "INSERT INTO tmashebi( saxeli, janri, weli, shemqmneli, mogeba, cover_url) VALUES ('$saxeli', '$janri', '$weli', '$shemqmneli', '$mogeba', '$cover')";

	$result = mysqli_query($conn, $test);
	if ($result) {
		echo "daemata";
	}else{
		echo "</br>ar daemata";
	}

 ?>