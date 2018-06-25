#!/bin/bash

# rsync to backup
# -a: archive option -- recursive, copy symbolic links, preserves group and owner
# -v: verbose option -- displays progress
# -H: hardlinks option -- preserve hard links

rsync –avH /home/ /media/backup/
rsync –avH /etc/ /media/backup/
rsync –avH /var/www/html/ /media/backup/
rsync –avH /var/tmp/ /media/backup/

echo Backup complete. Any errors should be logged and reported to a System Administrator. 

#!/bin/bash
# rsync to restore
# -a: archive option -- recursive, copy symbolic links, preserves group and owner
# -v: verbose option -- displays progress
# -H: hardlinks option -- preserve hard links

rsync –avH /media/backup/ /home/ 
rsync –avH /media/backup/ /etc/ 
rsync –avH /media/backup/ /var/www/html/ 
rsync –avH /media/backup/ /var/tmp/ 
