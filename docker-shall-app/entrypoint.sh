#!/bin/bash

# Create directory if it doesn't exist
mkdir -p /myapp/logmon

# Redirect logs to the specified file
exec > /myapp/logmon/application.log 2>&1

# Execute the CMD or provided command
exec "$@"