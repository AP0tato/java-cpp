package cube.engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import cube.renderEngine.DisplayManager;
import cube.renderEngine.Loader;
import cube.renderEngine.RawModel;
import cube.renderEngine.Renderer;
import cube.shaders.StaticShader;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertices = {			
				-0.5f,-.5f,0,	//V0
				0.1f,.1f,0,	//V1
				.6f,-.5f,0,	//V2
				//1f,1f,0		//V3
		};
		
		int[] indices = {
				0,1,2,	//Top left triangle (V0,V1,V3)
				//3,1,2	//Bottom right triangle (V3,V1,V2)
		};
		
		RawModel model = loader.loadToVAO(vertices,indices);
		
		while(!Display.isCloseRequested()){
			//game logic
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();			
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
