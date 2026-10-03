// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot;

// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.XboxController;

// /**
//  * The methods in this class are called automatically corresponding to each mode, as described in
//  * the TimedRobot documentation. If you change the name of this class or the package after creating
//  * this project, you must also update the manifest file in the resource directory.
//  */
// public class Robot extends TimedRobot {
//   private final SparkMax motor_09 = new SparkMax(9, MotorType.kBrushless);
//   private final SparkMax motor_32 = new SparkMax(32, MotorType.kBrushless);
//   private final XboxController m_controller = new XboxController(0);



//   /** Called once at the beginning of the robot program. */
//   public Robot() {
//   }

//   /** This function is called periodically during teleoperated mode. */
//   @Override
//   public void teleopPeriodic() {
//     motor_32.set(m_controller.getLeftY());
//     motor_09.set(m_controller.getRightY());
//   }
// }





// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot;

// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.XboxController;

// /**
//  * The methods in this class are called automatically corresponding to each mode, as described in
//  * the TimedRobot documentation. If you change the name of this class or the package after creating
//  * this project, you must also update the manifest file in the resource directory.
//  */
// public class Robot extends TimedRobot {
//   private final SparkMax motor_09 = new SparkMax(9, MotorType.kBrushless);
//   private final SparkMax motor_32 = new SparkMax(32, MotorType.kBrushless);
//   private final XboxController m_controller = new XboxController(0);

//   // Define operational modes
//   private enum Mode {
//     JOYSTICK_CONTROL,
//     FULL_SPEED_A_BUTTON
//   }

//   // Initialize in default mode
//   private Mode currentMode = Mode.JOYSTICK_CONTROL;

//   /** Called once at the beginning of the robot program. */
//   public Robot() {
//   }

//   /** This function is called periodically during teleoperated mode. */
//   @Override
//   public void teleopPeriodic() {
//     // Mode Switching Logic
//     if (m_controller.getRightBumper()) {
//       currentMode = Mode.FULL_SPEED_A_BUTTON;
//     } else if (m_controller.getLeftBumper()) {
//       currentMode = Mode.JOYSTICK_CONTROL;
//     }

//     // Behavior based on active mode
//     switch (currentMode) {
//       case JOYSTICK_CONTROL:
//         motor_32.set(m_controller.getLeftY());
//         motor_09.set(m_controller.getRightY());
//         break;

//       case FULL_SPEED_A_BUTTON:
//         if (m_controller.getAButton()) {
//           motor_32.set(1.0);
//           motor_09.set(1.0);
//         } else {
//           motor_32.set(0.0);
//           motor_09.set(0.0);
//         }
//         break;
//     }
//   }
// }





// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot;

// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import edu.wpi.first.math.filter.SlewRateLimiter;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.XboxController;

// /**
//  * The methods in this class are called automatically corresponding to each mode, as described in
//  * the TimedRobot documentation. If you change the name of this class or the package after creating
//  * this project, you must also update the manifest file in the resource directory.
//  */
// public class Robot extends TimedRobot {
//   private final SparkMax motor_09 = new SparkMax(9, MotorType.kBrushless);
//   private final SparkMax motor_32 = new SparkMax(32, MotorType.kBrushless);
//   private final XboxController m_controller = new XboxController(0);

//   // Rate limiter: limits speed change to 1.0 unit per second (0 to 100% in 1 second)
//   private final SlewRateLimiter m_limiter = new SlewRateLimiter(1.0);

//   // Define operational modes
//   private enum Mode {
//     JOYSTICK_CONTROL,
//     FULL_SPEED_A_BUTTON
//   }

//   // Initialize in default mode
//   private Mode currentMode = Mode.JOYSTICK_CONTROL;

//   /** Called once at the beginning of the robot program. */
//   public Robot() {
//   }

//   /** This function is called periodically during teleoperated mode. */
//   @Override
//   public void teleopPeriodic() {
//     // Mode Switching Logic
//     if (m_controller.getRightBumper()) {
//       currentMode = Mode.FULL_SPEED_A_BUTTON;
//     } else if (m_controller.getLeftBumper()) {
//       currentMode = Mode.JOYSTICK_CONTROL;
//     }

//     // Behavior based on active mode
//     switch (currentMode) {
//       case JOYSTICK_CONTROL:
//         // Reset the rate limiter when returning to joystick mode so it doesn't carry old state
//         m_limiter.reset(0.0);

//         motor_32.set(m_controller.getLeftY());
//         motor_09.set(m_controller.getRightY());
//         break;

//       case FULL_SPEED_A_BUTTON:
//         // Target speed is 1.0 when A is held, 0.0 when released
//         double targetSpeed = m_controller.getAButton() ? 1.0 : 0.0;

//         // Calculate rate-limited speed output
//         double rampedSpeed = m_limiter.calculate(targetSpeed);

//         motor_32.set(rampedSpeed);
//         motor_09.set(rampedSpeed);
//         break;
//     }
//   }
// }





// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends TimedRobot {
  private final SparkMax motor_09 = new SparkMax(9, MotorType.kBrushless);
  private final SparkMax motor_32 = new SparkMax(32, MotorType.kBrushless);
  private final XboxController m_controller = new XboxController(0);

  // Rate limiter: limits speed change to 1.0 unit per second
  private final SlewRateLimiter m_limiter = new SlewRateLimiter(2.5);

  // Tracks continuous state for A (Start) and B (Stop) toggle buttons
  private boolean m_continuousRun = false;

  // Define operational modes
  private enum Mode {
    JOYSTICK_CONTROL,
    FULL_SPEED_CONTROL
  }

  // Initialize in default mode
  private Mode currentMode = Mode.JOYSTICK_CONTROL;

  /** Called once at the beginning of the robot program. */
  public Robot() {
  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    // Mode Switching Logic
    if (m_controller.getRightBumper()) {
      currentMode = Mode.FULL_SPEED_CONTROL;
    } else if (m_controller.getLeftBumper()) {
      currentMode = Mode.JOYSTICK_CONTROL;
    }

    // Behavior based on active mode
    switch (currentMode) {
      case JOYSTICK_CONTROL:
        // Reset state and limiter when returning to joystick mode
        m_continuousRun = false;
        m_limiter.reset(0.0);

        motor_32.set(-m_controller.getLeftY());
        motor_09.set(-m_controller.getRightY());
        break;

      case FULL_SPEED_CONTROL:
        // Handle A (Start) and B (Stop) toggle buttons
        if (m_controller.getAButtonPressed()) {
          m_continuousRun = true;
        } else if (m_controller.getBButtonPressed()) {
          m_continuousRun = false;
        }

        // Target speed is 1.0 if X is held OR if continuous run (A) is active
        double targetSpeed = (m_controller.getXButton() || m_continuousRun) ? 1.0 : 0.0;

        // Calculate rate-limited speed output
        double rampedSpeed = m_limiter.calculate(targetSpeed);

        motor_32.set(rampedSpeed);
        motor_09.set(rampedSpeed);
        break;
    }
  }
}