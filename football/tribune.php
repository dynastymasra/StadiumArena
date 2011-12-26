<?php
	include_once("database.php");

  	$sqlString = "SELECT tribuneOne, tribuneTwo, tribuneThree FROM tribune";
	$rs = mysql_query($sqlString);

	if($rs) {
   		while($objRs = mysql_fetch_assoc($rs)) {
      		$output[] = $objRs;
   		}
   	echo json_encode($output);
	}
	mysql_close();
?>