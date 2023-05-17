<?php
require 'connection.php';
require 'getAge.php';

$result=$connDB->query("SELECT dipendenti.stip_mens, dipendenti.data_nascita FROM dipendenti");
$stip_media=0;
$eta_media=0;
$i=0;
if($result->num_rows!=0){
    while($row=$result->fetch_assoc()){
        $stip_mens=$row["stip_mens"];
        $data_nascita=$row["data_nascita"];
        $eta= getAge($data_nascita);
        $eta_media+=$eta;
        $stip_media+=$stip_mens;
        $i++;
    }
    $stip_media/=$i;
    $eta_media/=$i;
    echo "$stip_media".","."$eta_media";
}else{
    echo 'Nessun dipendente trovato';
}
   

?>

