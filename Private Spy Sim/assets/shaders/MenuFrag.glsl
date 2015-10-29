/*
#ifdef GL_ES
precision highp float;
precision mediump int;
#endif

uniform sampler2D texture;
uniform float time;
uniform float ar;

varying vec4 vertColor;
varying vec4 vertTexCoord;


float circle(vec2 uv, float r){
return(step(length(uv),r));
}

mat2 rotate(float a){
return(mat2(-sin(a),cos(a),cos(a),sin(a)));
}


void main() {
vec2 uv = ((vertTexCoord.st*2.0)-1.0); uv = vec2(uv.x,uv.y*ar);
vec3 col = vec3(.2,0.3,.45-uv.y*.04)+.07*-uv.y;
uv = uv * rotate(-3.14159/12.);
float cv = circle(fract((uv-vec2(0.0,.1*time))*2.)-vec2(2./5.),.15);
col = col - vec3(-.35*cv,.3*cv,0.3*cv);

fragColor = vec4( col, 1.0 );
}*/

#ifdef GL_ES
precision highp float;
precision mediump int;
#endif

uniform sampler2D texture;
uniform float time;
uniform float ar;

varying vec4 vertColor;
varying vec4 vertTexCoord;

float circle(vec2 uv, float r){
return(step(length(uv),r));
}

float rect(vec2 uv, float w,float h){
return(step(abs(uv.x),w)*step(abs(uv.y),h));
}

mat2 rotate(float a){
return(mat2(-sin(a),cos(a),cos(a),sin(a)));
}

vec3 powmix(vec3 c1, vec3 c2, float a){
return(sqrt(mix(pow(c1,vec3(2.)),pow(c2,vec3(2.)),a)));
}

void main() {
vec2 uv = ((vertTexCoord.st*2.0)-1.0);uv = vec2(uv.x, uv.y *ar);
uv=uv*1.3*rotate(time*.8);
//----------------------------------------------------------------------------------------------------------
vec3 col = vec3(rect(vec2(fract(uv.x*5.-time),fract(uv.y*2.5)),.2,.1))*vec3(.55,.05,.1);
col = col + vec3(rect(vec2(fract(uv.x*5.),fract(uv.y*2.5-.5-time)),.2,.1))*vec3(.3,.5,.95);

fragColor = vec4( col, 1.0 );
}