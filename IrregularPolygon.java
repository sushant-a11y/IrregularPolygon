import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool
public class IrregularPolygon{
  		private final ArrayList <Point2D.Double> myPolygon= new ArrayList<>();

  		public void add(Point2D.Double aPoint) {
            myPolygon.add(aPoint);
         }

   		public void draw() {
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            myDrawingTool.up();
            for(Point2D.Double p:myPolygon){
                myDrawingTool.move(p.x,p.y);
                myDrawingTool.down();
            }
            myDrawingTool.move(myPolygon.getFirst().x,myPolygon.getFirst().y);
        }


   		public double perimeter() {
            double per=0;
            for (int i=0; i<myPolygon.size()-1;i++){
                per+=Math.sqrt(Math.pow(myPolygon.get(i+1).y-myPolygon.get(i).y,2)+(Math.pow(myPolygon.get(i+1).x-myPolygon.get(i).x,2)));
            }
            per+=Math.sqrt(Math.pow(myPolygon.getLast().y-myPolygon.getFirst().y,2)+(Math.pow(myPolygon.getLast().x-myPolygon.getFirst().x,2)));
            return per;
        }

   		public double area() {
            double area=0;
            for (int i=0; i<myPolygon.size()-1;i++){
                area+=myPolygon.get(i).x*myPolygon.get(i+1).y;
            }
            area+=myPolygon.getLast().x*myPolygon.getFirst().y;
            for (int i=0; i<myPolygon.size()-1;i++){
                area-=myPolygon.get(i).y*myPolygon.get(i+1).x;
            }
            area-=myPolygon.getLast().y*myPolygon.getFirst().x;
            area/=2;
            area=Math.abs(area);
            return area;
        }
}
