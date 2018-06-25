Backup project instructions for ITEC 325 - System Administration

[Initial] BACKUP Procedures:

Putty ssh connection to rubberducky - 10.0.1.231
Login as mschmi22
enter password

cd / 
ls (if no media directory is present, then mkdir media)
cd media
mkdir backup
cd backup
sudo nano backup
type in backup script as shown above previously in this word document
sudo chmod 755 backup (755 = read, write, execute for owner -- read, execute for group and all)
Plug in usb flash drive
df -ah (find device name -- for example: /media/USB-DRIVE
sudo mount -t ext3 /media/USB-DRIVE /media/backup
./backup
verify backup is complete
cd /media/USB-DRIVE
ls -al
cd /media/backup
umount /media/USB-DRIVE
unplug usb flash drive
plug in external hard drive
sudo mount -t ext3 /media/EXT-DRIVE /media/backup
./backup
verify backup is complete
cd /media/EXT-DRIVE
ls -al
cd /media/backup
umount /media/EXT-DRIVE
unplug external hard drive
logout
