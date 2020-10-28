#!/bin/bash
for i in {1..12}
do
    wget "http://transtats.bts.gov/PREZIP/On_Time_Reporting_Carrier_On_Time_Performance_1987_present_2019_$i.zip"
done
