module.exports = function(grunt) {


  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {

      build: {
        src: 'src/**.js',
        dest: 'dist/<%= pkg.name %>.min.js'
      }
    }
    
  });


  grunt.loadNpmTasks('grunt-contrib-uglify');


  grunt.registerTask('Default', ['uglify']);


}; 