# using SSH & Terminal

Test your connection to the cluster : 

## Windows : 

- Install [Mobaxterm](https://download.mobatek.net/2022020030522248/MobaXterm_Portable_v20.2.zip)

- Download this private key : [ppk file](/res/bin/BCG2610.ppk)<br>
  Select "Raw", and save (Ctrl-S or Cmd-S). Be sure to remove .txt extension and keep .ppk

- Use MobaXterm to ssh to the test machine : Sessions > New Session > SSH TAB
```
    User : ec2-user
    Remote Host : your.ip.add.ress
    Check Use Private Key : select ppk file path
```
![mobaxterm](/res/img/mobaxterm.png)



## MacOS / Linux : 

- Download this private key : [pem file](/res/bin/BCG2610.pem)<br>
  Select "Raw", and save (Ctrl-S or Cmd-S). Be sure to remove .txt extension and keep .pem

```
    chmod 400 BCG2210.pem
    ssh -i BCG2210.pem ec2-user@your.ip.add.ress
```

### AS SOON AS YOU SSH IN

Your access is confirmed. 
You are asked to kindly leave. 
