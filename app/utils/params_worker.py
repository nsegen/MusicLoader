import logging

logger = logging.getLogger(__name__)


def get_songs_from_file(args):
    try:
        file_name = args.pop(args.index('-f') + 1)
        songs = [line.strip() for line in open(file=file_name).readlines()]
    except IndexError:
        songs = []
        logger.error('Expected file name after "-f"')
    return songs


def get_songs_list(args):
    try:
        song_list = args[args.index('-f') + 1:]
    except IndexError:
        song_list = []
        logger.error('Expected songs list after "-l"')
    return song_list


def get_song_name(args):
    try:
        song = args.pop(args.index('-s') + 1)
    except IndexError:
        song = None
        logger.error('Expected song name after "-s"')
    return [song, ]


def get_out_dir(args):
    try:
        out_dir = args.pop(args.index('-o') + 1)
    except IndexError:
        out_dir = '.'
        logger.error('Expected songs list after "-o"')
    return out_dir
