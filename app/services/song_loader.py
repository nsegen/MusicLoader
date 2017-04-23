import os
import subprocess
from threading import Thread
import logging

logger = logging.getLogger(__name__)


class SongLoader(Thread):

    def __init__(self, song, out_dir, lock):
        Thread.__init__(self)
        print(song)
        self.daemon = True
        self.song = song
        self.out_dir = out_dir
        self.lock = lock

    def run(self):
        self.lock.acquire(True)
        logger.info('{}: start loading'.format(self.song))
        cwd = os.path.join(self.out_dir, self.song)
        if not os.path.isdir(cwd):
            os.mkdir(cwd)
            logger.debug('{} does not exist'.format(cwd))
        else:
            logger.debug('{} is exist'.format(cwd))

        # subprocess.Popen(('instantmusic', '-s', self.song), cwd=self.out_dir, stdin=subprocess.PIPE)
        self.lock.release()
