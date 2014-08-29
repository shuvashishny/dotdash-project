<?php

   
$file = fopen("todo.list", "r");
$members = array();

while (!feof($file)) {
   $members[] = fgets($file);
}

fclose($file);

$content = json_encode($members);


var_dump($content);


?>