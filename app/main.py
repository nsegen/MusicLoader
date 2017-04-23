import logging
import os
import sys
import threading

from utils import *
from services import SongLoader

logging.basicConfig(
    level=logging.DEBUG,
)

logger = logging.getLogger(__name__)


args = sys.argv

songs = []

params = {
    '-f': get_songs_from_file,
    '-l': get_songs_list,
    '-s': get_song_name,
}

for param in params:
    if param in args:
        songs += params[param](args)

if '-o' in args:
    out_dir = get_out_dir(args)
else:
    out_dir = '.'

if not os.path.isdir(out_dir):
    os.mkdir(out_dir)
    logger.info('{} does not exist and was created'.format(out_dir))
else:
    logger.debug('{} is exist'.format(out_dir))

logger.debug(songs)
dir_lock = threading.Lock()
for song in songs:
    song_loader = SongLoader(song=song, out_dir=out_dir, lock=dir_lock)
    song_loader.start()
