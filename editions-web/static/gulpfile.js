const gulp = require('gulp'); // eslint-disable-line import/no-extraneous-dependencies
const stylus = require('gulp-stylus'); // eslint-disable-line import/no-extraneous-dependencies
const nib = require('nib');

const SRC = './style.styl';

const build = () => (
  gulp
    .src('style.styl')
    .pipe(stylus({ use: [nib()] }))
    .pipe(gulp.dest(__dirname))
);

if (process.env.WATCH) {
  build();
  gulp.watch(SRC, () => {
    console.log('Building `style.styl`...'); // eslint-disable-line no-console
    build();
  });
} else {
  build();
}
