# When files are generated in the Docker container, run this.

sudo chown jeff -R .
sudo find . -type f -exec chmod 0644 {} \;
sudo find . -type d -exec chmod 744 {} \;
