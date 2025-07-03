#!/usr/bin/env sh

# -----------------------------------------------------------------------------
# Gradle start up script for UN*X
# -----------------------------------------------------------------------------

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
esac

# Attempt to set JAVA_HOME if it's not already set
if [ -z "$JAVA_HOME" ] ; then
    if $darwin ; then
        if [ -x "/usr/libexec/java_home" ]; then
            export JAVA_HOME=`/usr/libexec/java_home`
        fi
    fi
fi

if [ -z "$JAVA_HOME" ] ; then
    die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
fi

JAVA="$JAVA_HOME/bin/java"

# Determine the location of the gradle-wrapper.jar file
WRAPPER_JAR="$APP_BASE_NAME/gradle/wrapper/gradle-wrapper.jar"
WRAPPER_JAR="$(cd "$(dirname "$0")" && pwd)/gradle/wrapper/gradle-wrapper.jar"

# Check that gradle-wrapper.jar exists
if [ ! -r "$WRAPPER_JAR" ]; then
    echo "Downloading gradle-wrapper.jar..."
    curl -s https://services.gradle.org/distributions/gradle-8.4-bin.zip -o gradle-8.4-bin.zip
    unzip -q gradle-8.4-bin.zip
    cp gradle-8.4/lib/gradle-wrapper-*.jar gradle/wrapper/gradle-wrapper.jar
fi

exec "$JAVA" $DEFAULT_JVM_OPTS -jar "$WRAPPER_JAR" "$@"
