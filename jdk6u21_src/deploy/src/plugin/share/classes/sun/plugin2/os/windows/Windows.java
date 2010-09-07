/* !---- DO NOT EDIT: This file autogenerated by com\sun\gluegen\JavaEmitter.java on Sun Mar 09 19:50:51 GMT-08:00 2008 ----! */

package sun.plugin2.os.windows;

import java.nio.*;
import sun.plugin2.gluegen.runtime.*;

public class Windows 
{

  public static final int ERROR_PIPE_CONNECTED = 535;
  public static final int STATUS_ABANDONED_WAIT_0 = 0x00000080;
  public static final int WAIT_ABANDONED = 0x00000080;
  public static final int STATUS_WAIT_0 = 0x00000000;
  public static final int WAIT_OBJECT_0 = 0x00000000;
  public static final int WAIT_TIMEOUT = 258;
  public static final long INFINITE = 0xFFFFFFFF;
  public static final int EVENT_ALL_ACCESS = 0x001F0003;
  public static final int PIPE_ACCESS_INBOUND = 0x00000001;
  public static final int PIPE_ACCESS_OUTBOUND = 0x00000002;
  public static final int PIPE_ACCESS_DUPLEX = 0x00000003;
  public static final int PIPE_WAIT = 0x00000000;
  public static final int PIPE_NOWAIT = 0x00000001;
  public static final int PIPE_READMODE_BYTE = 0x00000000;
  public static final int PIPE_READMODE_MESSAGE = 0x00000002;
  public static final int PIPE_TYPE_BYTE = 0x00000000;
  public static final int PIPE_TYPE_MESSAGE = 0x00000004;
  public static final int PIPE_UNLIMITED_INSTANCES = 255;
  public static final int CREATE_NEW = 1;
  public static final int CREATE_ALWAYS = 2;
  public static final int OPEN_EXISTING = 3;
  public static final int OPEN_ALWAYS = 4;
  public static final int TRUNCATE_EXISTING = 5;
  public static final int FILE_SHARE_READ = 0x00000001;
  public static final int FILE_SHARE_WRITE = 0x00000002;
  public static final int FILE_SHARE_DELETE = 0x00000004;
  public static final int FILE_ATTRIBUTE_READONLY = 0x00000001;
  public static final int FILE_ATTRIBUTE_HIDDEN = 0x00000002;
  public static final int FILE_ATTRIBUTE_SYSTEM = 0x00000004;
  public static final int FILE_ATTRIBUTE_DIRECTORY = 0x00000010;
  public static final int FILE_ATTRIBUTE_ARCHIVE = 0x00000020;
  public static final int FILE_ATTRIBUTE_DEVICE = 0x00000040;
  public static final int FILE_ATTRIBUTE_NORMAL = 0x00000080;
  public static final int FILE_ATTRIBUTE_TEMPORARY = 0x00000100;
  public static final int FILE_ATTRIBUTE_SPARSE_FILE = 0x00000200;
  public static final int FILE_ATTRIBUTE_REPARSE_POINT = 0x00000400;
  public static final int FILE_ATTRIBUTE_COMPRESSED = 0x00000800;
  public static final int FILE_ATTRIBUTE_OFFLINE = 0x00001000;
  public static final int FILE_ATTRIBUTE_NOT_CONTENT_INDEXED = 0x00002000;
  public static final int FILE_ATTRIBUTE_ENCRYPTED = 0x00004000;
  public static final long FILE_FLAG_WRITE_THROUGH = 0x80000000;
  public static final int FILE_FLAG_OVERLAPPED = 0x40000000;
  public static final int FILE_FLAG_NO_BUFFERING = 0x20000000;
  public static final int FILE_FLAG_RANDOM_ACCESS = 0x10000000;
  public static final int FILE_FLAG_SEQUENTIAL_SCAN = 0x08000000;
  public static final int FILE_FLAG_DELETE_ON_CLOSE = 0x04000000;
  public static final int FILE_FLAG_BACKUP_SEMANTICS = 0x02000000;
  public static final int FILE_FLAG_POSIX_SEMANTICS = 0x01000000;
  public static final int FILE_FLAG_OPEN_REPARSE_POINT = 0x00200000;
  public static final int FILE_FLAG_OPEN_NO_RECALL = 0x00100000;
  public static final int FILE_FLAG_FIRST_PIPE_INSTANCE = 0x00080000;
  public static final long GENERIC_READ = 0x80000000;
  public static final int GENERIC_WRITE = 0x40000000;
  public static final int GENERIC_EXECUTE = 0x20000000;
  public static final int GENERIC_ALL = 0x10000000;
  public static final int FLASHW_CAPTION = 0x00000001;
  public static final int MB_OK = 0x00000000;
  public static final int VER_PLATFORM_WIN32s = 0;
  public static final int VER_PLATFORM_WIN32_WINDOWS = 1;
  public static final int VER_PLATFORM_WIN32_NT = 2;

  /** Interface to C language function: <br> <code> BOOL_PARAM CloseHandle(HANDLE hObject); </code>    */
  public static native boolean CloseHandle(long hObject);

  /** Interface to C language function: <br> <code> BOOL_PARAM ConnectNamedPipe(HANDLE hNamedPipe, LPOVERLAPPED lpOverlapped); </code>    */
  public static boolean ConnectNamedPipe(long hNamedPipe, OVERLAPPED lpOverlapped)
  {
      return ConnectNamedPipe0(hNamedPipe, ((lpOverlapped == null) ? null : lpOverlapped.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> BOOL_PARAM ConnectNamedPipe(HANDLE hNamedPipe, LPOVERLAPPED lpOverlapped); </code>    */
  private static native boolean ConnectNamedPipe0(long hNamedPipe, java.nio.ByteBuffer lpOverlapped);

  /** Interface to C language function: <br> <code> HANDLE CreateEventA(PSECURITY_ATTRIBUTES lpEventAttributes, BOOL_PARAM bManualReset, BOOL_PARAM bInitialState, LPCSTR lpName); </code>    */
  public static long CreateEventA(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, java.lang.String lpName)
  {
      return CreateEventA0(((lpEventAttributes == null) ? null : lpEventAttributes.getBuffer()), bManualReset, bInitialState, lpName);
  }

  /** Entry point to C language function: <br> <code> HANDLE CreateEventA(PSECURITY_ATTRIBUTES lpEventAttributes, BOOL_PARAM bManualReset, BOOL_PARAM bInitialState, LPCSTR lpName); </code>    */
  private static native long CreateEventA0(java.nio.ByteBuffer lpEventAttributes, boolean bManualReset, boolean bInitialState, java.lang.String lpName);

  /** Interface to C language function: <br> <code> HANDLE CreateFileA(LPCSTR lpFileName, DWORD dwDesiredAccess, DWORD dwShareMode, PSECURITY_ATTRIBUTES lpSecurityAttributes, DWORD dwCreationDisposition, DWORD dwFlagsAndAttributes, HANDLE hTemplateFile); </code>    */
  public static long CreateFileA(java.lang.String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long hTemplateFile)
  {
      return CreateFileA0(lpFileName, dwDesiredAccess, dwShareMode, ((lpSecurityAttributes == null) ? null : lpSecurityAttributes.getBuffer()), dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile);
  }

  /** Entry point to C language function: <br> <code> HANDLE CreateFileA(LPCSTR lpFileName, DWORD dwDesiredAccess, DWORD dwShareMode, PSECURITY_ATTRIBUTES lpSecurityAttributes, DWORD dwCreationDisposition, DWORD dwFlagsAndAttributes, HANDLE hTemplateFile); </code>    */
  private static native long CreateFileA0(java.lang.String lpFileName, int dwDesiredAccess, int dwShareMode, java.nio.ByteBuffer lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long hTemplateFile);

  /** Interface to C language function: <br> <code> HANDLE CreateNamedPipeA(LPCSTR lpName, DWORD dwOpenMode, DWORD dwPipeMode, DWORD nMaxInstances, DWORD nOutBufferSize, DWORD nInBufferSize, DWORD nDefaultTimeOut, PSECURITY_ATTRIBUTES lpSecurityAttributes); </code>    */
  public static long CreateNamedPipeA(java.lang.String lpName, int dwOpenMode, int dwPipeMode, int nMaxInstances, int nOutBufferSize, int nInBufferSize, int nDefaultTimeOut, SECURITY_ATTRIBUTES lpSecurityAttributes)
  {
      return CreateNamedPipeA0(lpName, dwOpenMode, dwPipeMode, nMaxInstances, nOutBufferSize, nInBufferSize, nDefaultTimeOut, ((lpSecurityAttributes == null) ? null : lpSecurityAttributes.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> HANDLE CreateNamedPipeA(LPCSTR lpName, DWORD dwOpenMode, DWORD dwPipeMode, DWORD nMaxInstances, DWORD nOutBufferSize, DWORD nInBufferSize, DWORD nDefaultTimeOut, PSECURITY_ATTRIBUTES lpSecurityAttributes); </code>    */
  private static native long CreateNamedPipeA0(java.lang.String lpName, int dwOpenMode, int dwPipeMode, int nMaxInstances, int nOutBufferSize, int nInBufferSize, int nDefaultTimeOut, java.nio.ByteBuffer lpSecurityAttributes);

  /** Interface to C language function: <br> <code> BOOL_PARAM DisconnectNamedPipe(HANDLE hNamedPipe); </code>    */
  public static native boolean DisconnectNamedPipe(long hNamedPipe);

  /** Interface to C language function: <br> <code> BOOL_PARAM FlashWindowEx(PFLASHWINFO pfwi); </code>    */
  public static boolean FlashWindowEx(FLASHWINFO pfwi)
  {
      return FlashWindowEx0(((pfwi == null) ? null : pfwi.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> BOOL_PARAM FlashWindowEx(PFLASHWINFO pfwi); </code>    */
  private static native boolean FlashWindowEx0(java.nio.ByteBuffer pfwi);

  /** Interface to C language function: <br> <code> DWORD GetCurrentProcessId(void); </code>    */
  public static native int GetCurrentProcessId();

  /** Interface to C language function: <br> <code> DWORD GetLastError(void); </code>    */
  public static native int GetLastError();

  /** Interface to C language function: <br> <code> BOOL_PARAM GetVersionExA(POSVERSIONINFOA lpVersionInformation); </code>    */
  public static boolean GetVersionExA(OSVERSIONINFOA lpVersionInformation)
  {
      return GetVersionExA0(((lpVersionInformation == null) ? null : lpVersionInformation.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> BOOL_PARAM GetVersionExA(POSVERSIONINFOA lpVersionInformation); </code>    */
  private static native boolean GetVersionExA0(java.nio.ByteBuffer lpVersionInformation);

  /** Interface to C language function: <br> <code> BOOL_PARAM MessageBeep(UINT uType); </code>    */
  public static native boolean MessageBeep(int uType);

  /** Interface to C language function: <br> <code> HANDLE OpenEventA(DWORD dwDesiredAccess, BOOL_PARAM bInheritHandle, LPCSTR lpName); </code>    */
  public static native long OpenEventA(int dwDesiredAccess, boolean bInheritHandle, java.lang.String lpName);

  /** Interface to C language function: <br> <code> BOOL_PARAM ReadFile(HANDLE hFile, LPVOID lpBuffer, DWORD nNumberOfBytesToRead, LPDWORD lpNumberOfBytesRead, LPOVERLAPPED lpOverlapped); </code> 
      @param lpBuffer a direct {@link java.nio.Buffer}
      @param lpNumberOfBytesRead a direct {@link java.nio.IntBuffer}   */
  public static boolean ReadFile(long hFile, java.nio.Buffer lpBuffer, int nNumberOfBytesToRead, java.nio.IntBuffer lpNumberOfBytesRead, OVERLAPPED lpOverlapped)
  {
    if (!BufferFactory.isDirect(lpBuffer))
      throw new RuntimeException("Argument \"lpBuffer\" was not a direct buffer");
    if (!BufferFactory.isDirect(lpNumberOfBytesRead))
      throw new RuntimeException("Argument \"lpNumberOfBytesRead\" was not a direct buffer");
      return ReadFile0(hFile, lpBuffer, BufferFactory.getDirectBufferByteOffset(lpBuffer), nNumberOfBytesToRead, lpNumberOfBytesRead, BufferFactory.getDirectBufferByteOffset(lpNumberOfBytesRead), ((lpOverlapped == null) ? null : lpOverlapped.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> BOOL_PARAM ReadFile(HANDLE hFile, LPVOID lpBuffer, DWORD nNumberOfBytesToRead, LPDWORD lpNumberOfBytesRead, LPOVERLAPPED lpOverlapped); </code> 
      @param lpBuffer a direct {@link java.nio.Buffer}
      @param lpNumberOfBytesRead a direct {@link java.nio.IntBuffer}   */
  private static native boolean ReadFile0(long hFile, Object lpBuffer, int lpBuffer_byte_offset, int nNumberOfBytesToRead, Object lpNumberOfBytesRead, int lpNumberOfBytesRead_byte_offset, java.nio.ByteBuffer lpOverlapped);

  /** Interface to C language function: <br> <code> BOOL_PARAM ResetEvent(HANDLE hEvent); </code>    */
  public static native boolean ResetEvent(long hEvent);

  /** Interface to C language function: <br> <code> BOOL_PARAM SetEvent(HANDLE hEvent); </code>    */
  public static native boolean SetEvent(long hEvent);

  /** Interface to C language function: <br> <code> DWORD WaitForSingleObject(HANDLE hHandle, DWORD dwMilliseconds); </code>    */
  public static native int WaitForSingleObject(long hHandle, int dwMilliseconds);

  /** Interface to C language function: <br> <code> BOOL_PARAM WriteFile(HANDLE hFile, LPCVOID lpBuffer, DWORD nNumberOfBytesToWrite, LPDWORD lpNumberOfBytesWritten, LPOVERLAPPED lpOverlapped); </code> 
      @param lpBuffer a direct {@link java.nio.Buffer}
      @param lpNumberOfBytesWritten a direct {@link java.nio.IntBuffer}   */
  public static boolean WriteFile(long hFile, java.nio.Buffer lpBuffer, int nNumberOfBytesToWrite, java.nio.IntBuffer lpNumberOfBytesWritten, OVERLAPPED lpOverlapped)
  {
    if (!BufferFactory.isDirect(lpBuffer))
      throw new RuntimeException("Argument \"lpBuffer\" was not a direct buffer");
    if (!BufferFactory.isDirect(lpNumberOfBytesWritten))
      throw new RuntimeException("Argument \"lpNumberOfBytesWritten\" was not a direct buffer");
      return WriteFile0(hFile, lpBuffer, BufferFactory.getDirectBufferByteOffset(lpBuffer), nNumberOfBytesToWrite, lpNumberOfBytesWritten, BufferFactory.getDirectBufferByteOffset(lpNumberOfBytesWritten), ((lpOverlapped == null) ? null : lpOverlapped.getBuffer()));
  }

  /** Entry point to C language function: <br> <code> BOOL_PARAM WriteFile(HANDLE hFile, LPCVOID lpBuffer, DWORD nNumberOfBytesToWrite, LPDWORD lpNumberOfBytesWritten, LPOVERLAPPED lpOverlapped); </code> 
      @param lpBuffer a direct {@link java.nio.Buffer}
      @param lpNumberOfBytesWritten a direct {@link java.nio.IntBuffer}   */
  private static native boolean WriteFile0(long hFile, Object lpBuffer, int lpBuffer_byte_offset, int nNumberOfBytesToWrite, Object lpNumberOfBytesWritten, int lpNumberOfBytesWritten_byte_offset, java.nio.ByteBuffer lpOverlapped);


  // --- Begin CustomJavaCode .cfg declarations
  public static final long INVALID_HANDLE_VALUE = -1;
  static {
      // This is called very early in bootstrapping of the new plug-in
      // so we can't use the Config class to determine this answer
      String javaVersion = System.getProperty("java.version");
      if (javaVersion.startsWith("1.4") || javaVersion.startsWith("1.5")) {
          // Versions of Java before 1.6 don't have this dependent library
          // of the jp2native library, so need to load it manually
          sun.plugin2.util.NativeLibLoader.load(new String[] {"msvcr71"});
      }
      sun.plugin2.util.NativeLibLoader.load(new String[] {"jp2native"});
  }
  // ---- End CustomJavaCode .cfg declarations

} // end of class Windows