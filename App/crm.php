<?php

require 'connection.php';

$result=$connDB->query("SELECT * FROM sceltecrm");
if($result->num_rows!=0){
    $totr=0;
    $totSd1=0;
    $totSd2=0;
    $totSd3=0;
    $totSd4=0;
    $totSd5=0;
    $totSd6=0;
    $totSd7=0;
    $totSd8=0;
    $totSd9=0;
    $totSd10=0;
    while($row=$result->fetch_assoc()){
        $r1=$row["d1"];
        $r2=$row["d2"];
        $r3=$row["d3"];
        $r4=$row["d4"];
        $r5=$row["d5"];
        $r6=$row["d6"];
        $r7=$row["d7"];
        $r8=$row["d8"];
        $r9=$row["d9"];
        $r10=$row["d10"];
        $totr++;
        if($r1==1){
            $totSd1++;
        }
        if($r2==1){
            $totSd2++;
        }
        if($r3==1){
            $totSd3++;
        }
        if($r4==1){
            $totSd4++;
        }
        if($r5==1){
            $totSd5++;
        }
        if($r6==1){
            $totSd6++;
        }
        if($r7==1){
            $totSd7++;
        }
        if($r8==1){
            $totSd8++;
        }
        if($r9==1){
            $totSd9++;
        }
        if($r10==1){
            $totSd10++;
        }
    }
    $probd1=(100*$totSd1)/$totr;
    $probd2=(100*$totSd2)/$totr;
    $probd3=(100*$totSd3)/$totr;
    $probd4=(100*$totSd4)/$totr;
    $probd5=(100*$totSd5)/$totr;
    $probd6=(100*$totSd6)/$totr;
    $probd7=(100*$totSd7)/$totr;
    $probd8=(100*$totSd8)/$totr;
    $probd9=(100*$totSd9)/$totr;
    $probd10=(100*$totSd10)/$totr;
    
    if($probd1>50){
        $r1=1;
    } else {
        $r1=0;
    }
    if($probd2>50){
        $r2=1;
    } else {
        $r2=0;
    }
    if($probd3>50){
        $r3=1;
    } else {
        $r3=0;
    }
    if($probd4>50){
        $r4=1;
    } else {
        $r4=0;
    }
    if($probd5>50){
        $r5=1;
    } else {
        $r5=0;
    }
    if($probd6>50){
        $r6=1;
    } else {
        $r6=0;
    }
    if($probd7>50){
        $r7=1;
    } else {
        $r7=0;
    }
    if($probd8>50){
        $r8=1;
    } else {
        $r8=0;
    }
    if($probd9>50){
        $r9=1;
    } else {
        $r9=0;
    }
    if($probd10>50){
        $r10=1;
    } else {
        $r10=0;
    }
    echo "$r1".","."$r2".","."$r3".","."$r4".","."$r5".","."$r6".","."$r7".","."$r8".","."$r9".","."$r10";
}else{
    echo 'Nessuna scelta trovata';
}

?>

