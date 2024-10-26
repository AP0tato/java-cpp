#version 400 core

in vec3 position;

out vec3 color;

uniform int time;

void main(void)
{
	gl_Position = vec4(position, 1.0);
	color = vec3(position.x+.5, 1.0, position.y+.5);
}