// MainActivityFragment.java
// Fragment in which the DoodleView is displayed
package com.map524s1a.doodlzhp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment
{

   private DoodleView doodleView; // handles touch events and draws

   // called when Fragment's view needs to be created
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

   {
      super.onCreateView(inflater, container, savedInstanceState);

      View view = inflater.inflate(R.layout.fragment_main, container, false);

      setHasOptionsMenu(true); // this fragment has menu items to display

      // get reference to the DoodleView
      doodleView = (DoodleView) view.findViewById(R.id.doodleView);

      return view;
   }


   // displays the fragment's menu items
   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
   {

      super.onCreateOptionsMenu(menu, inflater);
      inflater.inflate(R.menu.doodle_fragment_menu, menu);

   }


   // handle choice from options menu
   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      // switch based on the MenuItem id

      switch (item.getItemId())
      {
         case R.id.color:
            ColorDialogFragment colorDialog = new ColorDialogFragment();
            colorDialog.show(getFragmentManager(), "color dialog");
            return true; // consume the menu event

         case R.id.line_width:
            LineWidthDialogFragment widthDialog = new LineWidthDialogFragment();
            widthDialog.show(getFragmentManager(), "line width dialog");
            return true; // consume the menu event

         case R.id.delete_drawing:
            EraseImageDialogFragment eraseDialog = new EraseImageDialogFragment();
            eraseDialog.show(getFragmentManager(), "erase dialog"); // confirm before erasing image
            return true; // consume the menu event
      }

      return super.onOptionsItemSelected(item);
   }


   // returns the DoodleView
   public DoodleView getDoodleView()
   {
      return doodleView;
   }
}