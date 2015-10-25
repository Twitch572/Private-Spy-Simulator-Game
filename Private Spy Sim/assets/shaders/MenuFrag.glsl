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
}