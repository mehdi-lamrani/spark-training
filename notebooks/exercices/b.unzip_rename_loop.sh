#!/bin/bash
for i in {1..12}
do
	unzip On_Time_Reporting_Carrier_On_Time_Performance_1987_present_2019_$i.zip
	mv "On_Time_Reporting_Carrier_On_Time_Performance_(1987_present)_2019_$i.csv" "BOTS_2019_$i.csv"
done
